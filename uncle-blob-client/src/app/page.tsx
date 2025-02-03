import React from 'react'
import PrimaryLinkButton from './components/buttons/PrimaryLinkButton'

export default function HomePage() {
  return (
    <div className='p-10 flex flex-col items-center justify-center text-center' >
      <h1 className='text-4xl md:text-7xl font-black' >Uncle Blob Client</h1>

      <p className='text-slate-500 mt-3' >Client UI for the easy to use light weight file server</p>

      <div className='w-full mt-3 items-center justify-center flex flex-wrap' >
        <PrimaryLinkButton className='mr-2' >View Docs</PrimaryLinkButton>
        <PrimaryLinkButton className='bg-green-500' >View Swagger Api Docs</PrimaryLinkButton>
      </div>
    </div>
  )
}
