import { getBackendUrl } from '@/lib/api/init.api'
import { FileUpload } from '@/lib/types/api.types'
import React from 'react'
import { FaCloudDownloadAlt, FaFileDownload } from 'react-icons/fa'

type Props = {
    uploads: FileUpload[]
}

export default function FileUploadTable({ uploads }: Props) {
    return (
        <div className='w-full'  >
            <table className='w-full' >

                <thead>
                    <tr>
                        <th>File Name</th>
                        <th>Extension</th>
                        <th>Content Type</th>
                        <th>File Name</th>
                        <th>Download</th>
                    </tr>
                </thead>

                <tbody>

                    {uploads.map((upload, index) => {
                        return <TableRow upload={upload} key={index} />
                    })}
                </tbody>
            </table>
        </div>
    )
}

type TableRowProps = {
    upload: FileUpload
}

function TableRow({upload}: TableRowProps) {
    const {fileName, fileSize, contentType, originalFileName} = upload;

    const endpoint = `/api/v1/files/download/${fileName}`;
    const downloadLink = getBackendUrl() + endpoint;

    return (
        <tr >
            <td className='p-1'>{originalFileName}</td>
            <td className='p-1' >{fileName.split(".").pop()}</td>
            <td className='p-1' >{contentType}</td>
            <td className='p-1 text-wrap' >{fileName}</td>
            <td className='p-1' >
                <a className='text-blue-500 text-center items-center justify-center h-full w-full flex' target='_blank' href={downloadLink} >
                    <FaCloudDownloadAlt />
                </a>
            </td>
        </tr>
    )
}
