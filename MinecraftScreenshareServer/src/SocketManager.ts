import UUIDWebSocket from './UUIDWebSocket';
import { v4 as uuidv4 } from 'uuid';

import * as WebSocket from 'ws';

export default class SocketManager {
  private sockets: Map<string, UUIDWebSocket>;
  private newSockets: Array<UUIDWebSocket>;

  constructor() {
    this.sockets = new Map();
    this.newSockets = [];
  }

  addConnection(ws: WebSocket): void {
    const uuid = uuidv4();
    console.log(`added connection with uuid, ${uuid}`);

    const uuidWs = new UUIDWebSocket(uuid, ws, this);
    this.sockets.set(uuid, uuidWs);
    this.newSockets.push(uuidWs);
  }

  removeConnection(uuid: string): boolean {
    return this.sockets.delete(uuid);
  }

  ping(payload: any) {
    for (const [uid, socket] of this.sockets) {
      socket.getWebsocket().send(payload);
    }
  }

  pingAllNew(payload: any) {
    for (const ws of this.newSockets) {
      ws.getWebsocket().send(payload);
    }
    this.newSockets = [];
  }

  hasNew(): boolean {
    return this.newSockets.length > 0;
  }
}
