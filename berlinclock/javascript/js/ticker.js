"use strict";

export class Ticker {
  constructor(count) {
    this._count = 0;
    this.lightbar = null;
  }

  tick() {
    this._count++;

    if (this._count === 60) {
      this._count = 0;
      this.lightbar && this.lightbar.increment();
    }
  }
}
