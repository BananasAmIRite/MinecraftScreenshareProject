import express from 'express';
import expressWs from 'express-ws';
import pinger from './ScreensharePinger';
import SocketManager from './SocketManager';
import { config } from 'dotenv';

config();

const app = expressWs(express()).app;

const socketMgr = new SocketManager();

app.ws('/', (ws, req) => {
  socketMgr.addConnection(ws);
});

app.get('/info', (req, res) => {
  console.log('a');

  res
    .status(200)
    .send({
      sizeX: parseInt(process.env.sizeX || '800'),
      sizeY: parseInt(process.env.sizeY || '450'),
    })
    .end();
});

app.listen(3000);

pinger(socketMgr);
