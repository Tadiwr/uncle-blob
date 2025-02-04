import { FileUpload } from '@/lib/types/api.types'
import React from 'react'

type Props = {
    upload: FileUpload
}

export default function FileUploadCard({upload}: Props) {
  return (
    <div className='rounded-xl bg-slate-100 p-5' >
      <h1>File Name: <strong>{upload.fileName}</strong></h1>
      <p>File Size: <strong>{upload.fileSize}</strong></p>
    </div>
  )
}
