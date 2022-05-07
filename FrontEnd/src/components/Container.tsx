import React, { ComponentPropsWithRef } from "react"

// type Props = {}

function Container({ children, className }: ComponentPropsWithRef<"div">) {
  return <div className={`container mx-auto ${className}`}>{children}</div>
}

export default Container
