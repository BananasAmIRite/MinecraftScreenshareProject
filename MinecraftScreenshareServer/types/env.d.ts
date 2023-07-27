declare namespace NodeJS {
  interface ProcessEnv extends Dict<string> {
    /**
     * Can be used to change the default timezone at runtime
     */
    TZ?: string;
    // fps: number;
  }
}
