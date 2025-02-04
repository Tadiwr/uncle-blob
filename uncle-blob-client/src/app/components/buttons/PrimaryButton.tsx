"use client";

import { TokensIcon } from "@radix-ui/react-icons";
import { ReactNode, HTMLAttributeAnchorTarget, useState } from "react"
import { useFormStatus } from "react-dom";
import { twMerge } from "tailwind-merge"

type Props = {
    href?: string,
    children?: ReactNode,
    className?: string,
    onClick?: () => void

}

export default function FormPrimaryButton({ children, className, onClick }: Props) {

    const {pending} = useFormStatus();

    return (
        <button type="submit" className={twMerge("bg-orange-400 text-white w-fit text-center py-1 md:py-2 px-3 rounded-xl hover:px-4 transition-all", className)} >
            <span>
                {pending ? <TokensIcon className="animate-spin" /> :  children} 
            </span>
        </button>
    )
}

export function PrimaryButton({ children, className, onClick }: Props) {

    const [pending, setPending] = useState(false);

    const handleOnClick = () => {
        
        if (onClick) {
            setPending(true);
            onClick();
            setPending(false);
        }

    }

    return (
        <button onClick={handleOnClick} type="submit" className={twMerge("bg-orange-400 text-white w-fit text-center py-2 md:py-2 px-3 rounded-xl hover:px-4 transition-all", className)} >
            <span>
                {pending ? <span className="flex flex-row items-center justify-center" >
                    <p className="mr-2" >Please Wait</p>
                    <TokensIcon className="animate-spin" />
                </span> 
                :  children} 
            </span>
        </button>
    )
}
