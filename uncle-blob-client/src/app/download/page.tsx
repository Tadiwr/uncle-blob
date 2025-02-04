"use client";

import React, { ChangeEvent, useState } from 'react'
import PrimaryLinkButton from '../components/buttons/PrimaryLinkButton';
import { getBackendUrl, getDownloadLink } from '@/lib/api/init.api';
import { FaCloudArrowDown } from 'react-icons/fa6';

export default function DownloadPage() {

    const FILE_NAME_FORM_NAME = "file_name";
    const DISPOSITION_FLAG = "flag";

    const [attachmentFlag, setAttachmentFlag] = useState(false);
    const [fileName, setFileName] = useState("");
    const [downloadLink, setDownloadLink] = useState("");

    const onChange = (e: ChangeEvent<HTMLInputElement>) => {
        const formFileName = e.target.value ?? "";
        setFileName(formFileName);
        setDownloadLink(getDownloadLink(formFileName, attachmentFlag));
    }

    const onChangeCheckbox = (e: ChangeEvent<HTMLInputElement>) => {

        const isChecked = e.target.checked;
        setAttachmentFlag(isChecked);
        setDownloadLink(getDownloadLink(fileName, isChecked));

    }

  return (
    <div className='p-5 py-10 flex flex-col items-center justify-center' >

        <h1 className='text-2xl font-medium p-5' >Download File</h1>

        <form action="" className='grid grid-cols-1 w-3/4 md:w-1/3 gap-3 ' >
            <input required value={fileName} onChange={onChange} type="text" name={FILE_NAME_FORM_NAME} placeholder='File Name' />
            
            <span className='w-full px-4' >

                <input type="checkbox" onChange={onChangeCheckbox} checked={attachmentFlag} name={DISPOSITION_FLAG} />

                <label className='ml-3' >
                    Attatchment Disposition
                </label>
            </span>

            {fileName != "" && 
                <PrimaryLinkButton 
                    target='_blank'
                    href={downloadLink}
                     className='w-full py-3 md:py-4' 
                >
                    <span className='flex flex-row items-center justify-center' >
                        <span className='mr-2' >Follow Download Link</span>
                        <FaCloudArrowDown />
                    </span>
                </PrimaryLinkButton>
            }
        </form>
    </div>
  )
}
