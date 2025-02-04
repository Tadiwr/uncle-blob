import React from 'react'
import { twMerge } from 'tailwind-merge'

type Props = {
    className?: string,
    errorMessage?: string
}

export default function ErrorCard(
    { className, errorMessage }: Props
) {
    if (errorMessage && errorMessage != "") {
        return (
            <div className={twMerge('bg-red-100 border p-3 rounded-xl text-red-400 text-center border-red-50', className)} >
                {errorMessage}
            </div>
        )
    }
}
