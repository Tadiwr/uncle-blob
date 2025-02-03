import React from 'react'
import PrimaryLinkButton from './components/buttons/PrimaryLinkButton'
import { getSwaggerUrl } from '@/lib/api/init.api';

export default function HomePage() {

  const githubLink = "https://github.com/Tadiwr/uncle-blob";
  const swaggerUiLink = getSwaggerUrl();

  return (
    <div className='p-10 flex flex-col items-center justify-center text-center' >
      <h1 className='text-4xl md:text-7xl font-black' >Uncle Blob Client</h1>

      <p className='text-slate-500 mt-3' >Client UI for the easy to use light weight file server</p>

      <div className='w-full mt-3 items-center justify-center flex flex-wrap' >
        <PrimaryLinkButton target='_blank' href={githubLink} className='mr-2 bg-slate-800' >Github</PrimaryLinkButton>
        <PrimaryLinkButton  target='_blank' href={swaggerUiLink} className='bg-green-500' >View Swagger Api Docs</PrimaryLinkButton>
      </div>
    </div>
  )
}
