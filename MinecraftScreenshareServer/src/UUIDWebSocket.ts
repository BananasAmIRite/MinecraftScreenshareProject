import SocketManager from './SocketManager';
import * as WebSocket from 'ws';

export default class UUIDWebSocket {
  constructor(private uuid: string, private ws: WebSocket, private mgr: SocketManager) {
    this._setupWs();
  }

  private _setupWs() {
    this.ws.onclose = () => {
      this.mgr.removeConnection(this.uuid);
    };
  }

  public getUuid() {
    return this.uuid;
  }

  public getWebsocket() {
    return this.ws;
  }
}
