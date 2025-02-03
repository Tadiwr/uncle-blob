"use cliet";

import React from 'react'
import { NavItem } from './NavBar';
import { usePathname } from 'next/navigation';
import { twMerge } from 'tailwind-merge';

type Props = {
    data: NavItem,
    className?:string
}

export default function NavLink({ data, className }: Props) {

    const pathName = usePathname();
    const {lable, href} = data;

    const isActive = href ? pathName.startsWith(href) : false;

    return (
        <a href={href} className={twMerge("font", isActive ? "text-black font-semibold" : "text-white hover:text-slate-200", className)} >
            {lable}
        </a>
    )
}
