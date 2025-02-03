import React from 'react'
import { NavItem } from './NavBar'

type Props = {
    navLinks: NavItem[]
}

export default function DesktopNavBar({navLinks}: Props) {
  return (
    <div className='hidden md:flex' >DesktopNavBar</div>
  )
}
