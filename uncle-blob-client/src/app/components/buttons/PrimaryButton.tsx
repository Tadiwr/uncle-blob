import { ReactNode, HTMLAttributeAnchorTarget, useState } from "react"
import { twMerge } from "tailwind-merge"

type Props = {
    href?: string,
    children?: ReactNode,
    className?: string,
    onClick?: () => void

}

export default function PrimaryButton({ href, children, className, onClick }: Props) {

    const [isPending, setIsPending] = useState(false);

    const handleOnClick = () => {
        setIsPending(true);
        setIsPending(false);
    }

    return (
        <button onClick={handleOnClick} className={twMerge("bg-orange-400 text-white w-fit text-center py-1 md:py-2 px-3 rounded-xl hover:px-4 transition-all", className)} >
            {children}
        </button>
    )
}
