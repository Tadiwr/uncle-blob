import type { Metadata } from "next";
import localFont from "next/font/local";
import "./globals.css";
import NavBar from "./components/navigation/NavBar";


const inter = localFont({
  src: "./fonts/Inter.ttf"
});

export const metadata: Metadata = {
  title: "Uncle Blob",
  description: "Uncle Blob Client",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body
        className={`${inter.className} antialiased`}
      > 
        <div className="fixed w-full top-0 left-0 bottom-0 h-16" >
          <NavBar />
        </div>

        <div className="mt-16" >
          {children}
        </div>
      </body>
    </html>
  );
}
