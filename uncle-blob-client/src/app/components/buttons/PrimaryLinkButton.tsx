import React, { ReactNode } from 'react'
import { twMerge } from 'tailwind-merge'

type Props = {
    href?: string,
    children?: ReactNode,
    className?:string
}

export default function PrimaryLinkButton({href, children, className}: Props) {
  return (
    <a href={href} className={twMerge("bg-orange-400 text-white w-fit text-center py-1 md:py-2 px-3 rounded-xl",className)} >
        {children}
    </a>
  )
}
