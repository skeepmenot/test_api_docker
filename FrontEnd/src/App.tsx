import clsx from "clsx"
import { useState } from "react"
import Container from "./components/Container"
import logo from "./logo.svg"

function App() {
  return (
    <div className="App  min-h-screen w-full bg-neutral-100">
      <Container className="w-10/12 pt-5 sm:w-5/12 sm:pt-8">
        <h1 className="font-noto-sarif font-bold text-light---primary-color">
          Todo App.
        </h1>
        <div className="mt-5">
          <form className="grid grid-flow-row grid-cols-3 gap-y-4 gap-x-4">
            <label htmlFor="todo-title" className="col-span-3 ">
              <input
                id="todo-title"
                type="text"
                spellCheck
                required
                placeholder="Please type title todo here."
                className={`w-full px-2 py-3 focus:outline-light---primary-hover-color  sm:w-60 `}
              />
            </label>
            <label htmlFor="" className="col-span-3">
              <textarea
                name=""
                id=""
                cols={30}
                rows={10}
                required
                className={`w-full p-4 focus:outline-light---primary-hover-color`}
                placeholder="Please type content here."></textarea>
            </label>
            <button
              className={clsx(
                "md:col-start-2 md:col-end-2",
                "col-span-3",
                "w-full",
                "rounded-md",
                "border",
                "border-light---negative-color",
                "hover:border-light---negative-color-hover",
                "bg-white",
                "px-4",
                "py-2",
                "text-light---negative-color",
                "hover:text-light---negative-color-hover",
                "disabled:text-light---disabled-text-color",
                "disabled:bg-light---disabled-background-color",
                "disabled:border-neutral-200",
                "disabled:cursor-not-allowed",
                "hover:shadow-md",
                "hover:shadow-light---negative-color/30"
              )}>
              Cancle
            </button>
            <button
              className={clsx(
                "md:col-start-3 md:col-end-3",
                "col-span-3",
                "w-full",
                "px-4",
                "py-2",
                "rounded-md",
                "bg-light---primary-color",
                "hover:bg-light---primary-hover-color",
                "hover:shadow-md",
                "hover:shadow-light---primary-color/40",
                "text-white",
                "hover:text-light---text-color-on-primary",
                "disabled:text-light---disabled-text-color",
                "disabled:bg-light---disabled-background-color",
                "disabled:border-neutral-300",
                "disabled:cursor-not-allowed"
              )}>
              Add todo.
            </button>
          </form>
        </div>
      </Container>
    </div>
  )
}

export default App
