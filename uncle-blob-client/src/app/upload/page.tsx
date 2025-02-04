"use client";

import React, { ChangeEvent, FormEvent, useState } from 'react'
import FormPrimaryButton, { PrimaryButton } from '../components/buttons/PrimaryButton';
import ErrorCard from '../components/cards/ErrorCard';
import { uploadFile } from '@/lib/api/init.api';
import { FileUpload } from '@/lib/types/api.types';
import FileUploadCard from '../components/cards/FileUploadCard';

export default function UploadPage() {

    const [file, setFile] = useState<File>();
    const [message, setMessage] = useState("");
    const [uploadRes, setUploadRes] = useState<FileUpload>();
    const [pending, setPending] = useState(false);

    const handleSubmit = async () => {

        setMessage("");
        console.log(file);
        
        if (file) {
            setPending(true);
            const res = await uploadFile(file);
            setUploadRes(res);
            setPending(false);
        }

        
    }

    const onFileChange = (e: ChangeEvent<HTMLInputElement>) => {
        const files = e.target.files;

        if (files) {   
            setFile(files[0]);
        }
    }

  return (
    <div className='p-5 flex flex-col items-center  h-full justify-center w-full' >
        <h1 className='mt-10 text-3xl font-medium' >Upload File</h1>

        <form onSubmit={(e) => e.preventDefault()} className='rounded-xl p-5 w-4/5 md:w-1/3 grid grid-cols-1 items-center justify-center' >

            <input required onChange={onFileChange} type="file" placeholder='File Name' />

            <PrimaryButton pending={pending} onClick={handleSubmit} className='w-full p-[10px] my-[5px]' >Upload</PrimaryButton>

            <ErrorCard className='mt-2' errorMessage={message} />
        </form>

        <div className='mt-10' >
            { uploadRes && <FileUploadCard upload={uploadRes} /> }
        </div>
    </div>
  )
}
