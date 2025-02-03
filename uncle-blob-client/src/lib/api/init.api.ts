import { config } from "dotenv"

config();

const BACKEND_URL = process.env.BACKEND_URL ?? "http://localhost:8888";

export function getSwaggerUrl() {
    const endpoint = "/swagger-ui.html";
    return BACKEND_URL + endpoint;
}