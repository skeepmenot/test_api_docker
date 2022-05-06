import React, { ComponentPropsWithRef } from "react"

// type Props = {}

function Container({ children }: ComponentPropsWithRef<"div">) {
  return <div className="mx-auto container ">{children}</div>
}

export default Container
