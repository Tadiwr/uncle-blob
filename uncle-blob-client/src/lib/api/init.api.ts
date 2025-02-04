import { config } from "dotenv"
import { FileUpload } from "../types/api.types";

config();

const BACKEND_URL = process.env.BACKEND_URL ?? "http://localhost:8888";

export function getSwaggerUrl() {
    const endpoint = "/swagger-ui.html";
    return BACKEND_URL + endpoint;
}

/** Returns the base address of the backend api
 * e.g `https://api.uncleblob.com` or  `http://localhost:8888`
 */
export function getBackendUrl() {
    return BACKEND_URL;
}

export async function getAllFileUploads() : Promise<FileUpload[]> {
    
    const endpoint = "/api/v1/files";
    const reqUrl = getBackendUrl() + endpoint;

    const apiRes = await fetch(reqUrl);
    const fileUploads = await apiRes.json() as FileUpload[];

    return fileUploads;
}

export async function uploadFile(file: File) : Promise<FileUpload> {

    const endpoint = "/api/v1/files/upload?fileName=" + file.name;
    const reqUrl = getBackendUrl() + endpoint;
    const bytes = (await file.arrayBuffer()).transfer();

    const apiRes = await fetch(reqUrl, {
        method: "POST",
        body: bytes,
        headers: {
            "Content-Type": file.type
        }
    });

    const res = await apiRes.json() as FileUpload;

    return res;

}