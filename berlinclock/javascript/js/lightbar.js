"use strict";

export class Lightbar {
  constructor(numberOfLights) {
    this._numberOfLights = numberOfLights;
    this._register = null;
    this.next = null;

    this._resetRegister();
  }

  increment() {
    let index = this._register.findIndex(it => !it);
    if (index !== -1) {
      this._register[index] = true;
    } else {
      this._resetRegister();
      this.next && this.next.increment();
    }
  }

  lights() {
    return this._register.slice(0);
  }

  _resetRegister() {
    this._register = new Array(this._numberOfLights);
    this._register.fill(false);
  }
}
