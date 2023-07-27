import SocketManager from './SocketManager';
import screenshot from 'screenshot-desktop';
import Jimp from 'jimp';

const getDiff = (img1: Jimp, img2: Jimp): Buffer => {
    if (!img1) return img2.bitmap.data;
    const d1 = img1.bitmap.data;
    const d2 = img2.bitmap.data;
    const deltaArr: number[] = [];

    let offset: number = 0;

    for (let y = 0; y < img1.bitmap.height; y++) {
        for (let x = 0; x < img1.bitmap.width; x++) {
            const clr1: number[] = [];
            const clr2: number[] = [];
            for (let c = 0; c < 4; c++) {
                clr1[c] = d1.readUint8(offset);
                clr2[c] = d2.readUInt8(offset);
                offset++;
                if (c !== 3) continue;
                // console.log(clr1);
                // console.log(clr2);

                // same pixel
                if (clr1.every((v, i) => v === clr2[i])) {
                    deltaArr.push(0, 0, 0, 0);
                } else {
                    // not similar
                    deltaArr.push(...clr2);
                }
            }
        }
    }
    return Buffer.from(deltaArr);
};

const getDiffArray = (img1: Jimp, img2: Jimp): { data: Array<Array<number>> } | Buffer => {
    if (!img1) return img2.bitmap.data;
    const d1 = img1.bitmap.data;
    const d2 = img2.bitmap.data;
    const deltaArr: number[][] = [];

    let offset: number = 0;

    for (let y = 0; y < img1.bitmap.height; y++) {
        for (let x = 0; x < img1.bitmap.width; x++) {
            const clr1: number[] = [];
            const clr2: number[] = [];
            for (let c = 0; c < 4; c++) {
                clr1[c] = d1.readUint8(offset);
                clr2[c] = d2.readUInt8(offset);
                offset++;
                if (c !== 3) continue;
                // console.log(clr1);
                // console.log(clr2);

                // not same pixel
                if (!clr1.every((v, i) => v === clr2[i])) {
                    deltaArr.push([x, y, ...clr2]);
                }
            }
        }
    }
    return { data: deltaArr };
};

export default async function pinger(mgr: SocketManager) {
    // TODO: on client end, implement some sort of special protocol for changing blocks so it doesnt have to loop through every single last black
    // aka maybe adapt getDiff() to use Map<number[], number[]> (Map<coordinate, rgba>)
    // we probably will use Array<Array<coordinate, rgba>>
    // i found this: https://levelup.gitconnected.com/parsing-json-arrays-as-objects-with-jackson-c2620e7cc439
    // so we are using Array<Array<xCoord, yCoord, r, g, b, a>>
    const PING_INTERVAL = 1000 / parseFloat(process.env.fps || '10');
    console.log(parseFloat(process.env.fps || '10'));
    const SIZE_X = parseInt(process.env.sizeX || '800');
    const SIZE_Y = parseInt(process.env.sizeY || '450');

    let lastImage: Jimp;
    let lastResized: Jimp;

    const ping = async () => {
        try {
            const ss = await screenshot({ filename: 'temp.jpg', format: 'jpeg' });

            const img = await Jimp.read(ss);

            if (!mgr.hasNew() && lastImage && lastImage.hash() === img.hash()) return;

            img.resize(SIZE_X, SIZE_Y, (err, a) => {
                if (err) return;
                // a.writeAsync('./out.jpg');
                // console.log(a.bitmap.data);
                const e = getDiffArray(lastResized, a);

                console.log('pinging');

                mgr.ping(e instanceof Buffer ? e : JSON.stringify(e));
                mgr.pingAllNew(a.bitmap.data);
                lastResized = a;
            });
            lastImage = img;
        } catch (err: any) {
            // console.log('Error occurred');
        }
    };

    while (true) {
        await ping();
        await wait(PING_INTERVAL);
    }
}

const wait = async (n: number) => {
    return new Promise((resolve) => {
        setTimeout(resolve, n);
    });
};
