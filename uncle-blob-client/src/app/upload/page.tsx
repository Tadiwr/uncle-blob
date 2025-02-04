"use client";

import React, { ChangeEvent, FormEvent, useState } from 'react'
import FormPrimaryButton, { PrimaryButton } from '../components/buttons/PrimaryButton';
import ErrorCard from '../components/cards/ErrorCard';

export default function UploadPage() {

    const [file, setFile] = useState<File>();
    const [message, setMessage] = useState("");

    const handleSubmit = () => {

        setMessage("");

        for (let x = 0; x < 100000000000000; x++) {
            console.log(x);
            
        }


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

        <form onSubmit={(e) => e.preventDefault()} className='rounded-xl p-5 w-4/5 md:w-1/3 grid grid-cols-1 items-center justify-center' >

            <input required onChange={onFileChange} type="file" placeholder='File Name' />

            <PrimaryButton onClick={handleSubmit} className='w-full p-[10px] my-[5px]' >Upload</PrimaryButton>

            <ErrorCard className='mt-2' errorMessage={message} />
        </form>
    </div>
  )
}
