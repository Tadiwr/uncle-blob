import { FileUpload } from '@/lib/types/api.types'
import React from 'react'

type Props = {
    upload: FileUpload
}

export default function FileUploadCard({upload}: Props) {
  return (
    <div>{upload.fileName}</div>
  )
}
