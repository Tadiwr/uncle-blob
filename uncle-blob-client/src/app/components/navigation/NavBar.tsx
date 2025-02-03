import React from 'react'
import DesktopNavBar from './DesktopNavBar'
import MobileNavBar from './MobileNavBar'

export type NavItem = {
    lable: string,
    href?: string
}

export default function NavBar() {

    const navLinks: NavItem[] = [
        {
            lable: "Home",
            href: "/"
        },

        {
            lable: "Upload",
            href: "/upload"
        },

        {
            lable: "Download",
            href: "/upload"
        }
    ]

  return (
    <div className='h-full '>
        <div className='hidden md:block h-full w-full' >
            <DesktopNavBar navLinks={navLinks} />
        </div>

        <div className='block md:hidden h-full w-full' >
            <MobileNavBar navLinks={navLinks} />
        </div>
    </div>
  )
}
