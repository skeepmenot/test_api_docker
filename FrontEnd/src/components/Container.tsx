import React, { ComponentPropsWithRef } from "react"

// type Props = {}

function Container({ children }: ComponentPropsWithRef<"div">) {
  return <div className="bg-red-200">{children}</div>
}

export default Container
