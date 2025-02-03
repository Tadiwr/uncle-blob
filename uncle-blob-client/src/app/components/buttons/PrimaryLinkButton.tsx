import React, { HTMLAttributeAnchorTarget, ReactNode } from 'react'
import { twMerge } from 'tailwind-merge'

type Props = {
    href?: string,
    children?: ReactNode,
    className?:string,
    target?:HTMLAttributeAnchorTarget | undefined
}

export default function PrimaryLinkButton({href, children, className, target}: Props) {
  return (
    <a href={href} target={target} className={twMerge("bg-orange-400 text-white w-fit text-center py-1 md:py-2 px-3 rounded-xl hover:px-4 transition-all",className)} >
        {children}
    </a>
  )
}
