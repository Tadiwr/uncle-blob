"use client";

import React from 'react'
import { NavItem } from './NavBar'
import NavLink from './NavLink'

type Props = {
  navLinks: NavItem[]
}

export default function DesktopNavBar({ navLinks }: Props) {
  return (
    <div className='hidden bg-orange-500 w-full md:flex flex-col items-center justify-start text-white h-full' >
      <div className=' w-full flex flex-row items-center h-full p-3' >
        <a href="/" className='font-bold text-lg' >UncleBlob</a>

        <div  className=' flex flex-row h-full items-center justify-start w-full ml-10' >
            {navLinks.map((link, index) => {
              return <NavLink className='p-2' data={link} key={index} />
            })}
        </div>
        
      </div>

    </div>
  )
}
