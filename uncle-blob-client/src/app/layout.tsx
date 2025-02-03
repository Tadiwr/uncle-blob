import type { Metadata } from "next";
import localFont from "next/font/local";
import "./globals.css";


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
        {children}
      </body>
    </html>
  );
}
