"use strict";

const Ticker = require("./ticker.js");
const Lightbar = require("./lightbar.js");

class BerlinClock {
  constructor(hour, minute) {
    const ticker = new Ticker();
    const bigHours = new Lightbar(4);
    const smallHours = new Lightbar(4);
    const bigMinutes = new Lightbar(11);
    const smallMinutes = new Lightbar(4);

    ticker.lightbar = smallMinutes;
    smallMinutes.next = bigMinutes;
    bigMinutes.next = smallHours;
    smallHours.next = bigHours;

    Object.assign(this, {
      triggerTicks(ticks) {
        for (let i = 0; i < ticks; i++) {
          ticker.tick();
        }
      },

      toString() {
        let str = "";

        bigHours.lights().forEach(it => (str += it ? "H" : "-"));
        smallHours.lights().forEach(it => (str += it ? "h" : "-"));
        bigMinutes.lights().forEach(it => (str += it ? "M" : "-"));
        smallMinutes.lights().forEach(it => (str += it ? "m" : "-"));

        return str;
      }
    });

    let seconds = 3600 * hour + 60 * minute;
    this.triggerTicks(seconds);
  }
}

module.exports = BerlinClock;
