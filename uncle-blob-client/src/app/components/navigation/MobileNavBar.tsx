import React from 'react'
import { NavItem } from './NavBar'

type Props = {
    navLinks: NavItem[]
}

export default function MobileNavBar({navLinks} : Props) {
  return (
    <div className='bg-green-400 w-full h-full' >
        <h1 className='' >UncleBlob</h1>
    </div>
  )
}
