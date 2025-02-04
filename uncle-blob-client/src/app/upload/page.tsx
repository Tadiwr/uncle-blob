"use client";

import React from 'react'
import PrimaryButton from '../components/buttons/PrimaryButton';

export default function UploadPage() {
  return (
    <div className='p-5 flex flex-col items-center  h-full justify-center w-full' >
        <h1>Upload File</h1>

        <form action="" className='bg-slate-100 rounded-xl p-5 w-4/5 md:w-1/3 h-fit flex flex-col' >

            <input name='file_name' type="text" placeholder='File Name' />
            <input name="file" type="file" placeholder='File Name' />

            <PrimaryButton className='w-full' >Upload</PrimaryButton>

        </form>
    </div>
  )
}
