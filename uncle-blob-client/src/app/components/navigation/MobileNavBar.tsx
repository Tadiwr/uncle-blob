"use client";

import React, { useState } from 'react'
import { NavItem } from './NavBar'
import NavLink from './NavLink';
import { twMerge } from 'tailwind-merge';

type Props = {
    navLinks: NavItem[]
}

export default function MobileNavBar({ navLinks }: Props) {

    const [showLinks, setShowLinks] = useState(false);

    const toogle = () => {
        setShowLinks(!showLinks);
    }

    return (
        <div className='md:hidden bg-orange-500 w-full flex flex-col items-center justify-start text-white h-full' >
            <div className=' w-full flex flex-row items-center h-full p-3' >
                <h1 className='font-bold text-lg' >UncleBlob</h1>

                <div onClick={toogle} className=' flex flex-row h-full items-center justify-end w-full' >
                    <div className={twMerge('grid grid-cols-1 gap-1 transition-all', showLinks ? "rotate-90" : "")} >
                        <div className='w-6 h-1 rounded-xl bg-white' ></div>
                        <div className='w-6 h-1 rounded-xl bg-white' ></div>
                        <div className='w-6 h-1 rounded-xl bg-white' ></div>
                    </div>
                </div>
            </div>

            { showLinks && <div className='bg-orange-500 w-full p-3 grid grid-cols-1 gap-2 ' >
                {navLinks.map((item, index) => {
                    return <NavLink data={item} key={index} />
                })}
            </div>}

        </div>
    )
}
