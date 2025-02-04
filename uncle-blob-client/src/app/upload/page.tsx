"use client";

import React, { ChangeEvent, FormEvent, useState } from 'react'
import PrimaryButton from '../components/buttons/PrimaryButton';

export default function UploadPage() {

    const [file, setFile] = useState<File>();

    const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        console.log(file);
        
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

        <form onSubmit={handleSubmit} className='rounded-xl p-5 w-4/5 md:w-1/3 grid grid-cols-1 items-center justify-center' >

            <input required onChange={onFileChange} type="file" placeholder='File Name' />

            <PrimaryButton className='w-full p-[10px] my-[5px]' >Upload</PrimaryButton>

        </form>
    </div>
  )
}
