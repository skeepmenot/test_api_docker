import { useState } from "react"
import Container from "./components/Container"
import logo from "./logo.svg"

function App() {
  return (
    <div className="App  min-h-screen w-full bg-neutral-100">
      <Container className="w-5/12 sm:pt-8">
        <h1 className="font-noto-sarif font-bold text-light---primary-color">
          Todo App.
        </h1>
        <p className="mt-2 text-base">
          {" "}
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatum
          corrupti nemo harum quidem commodi incidunt pariatur odit ipsa, minima
          reprehenderit sunt delectus aspernatur numquam consectetur libero
          illum nam, doloribus sint culpa deserunt quisquam! Mollitia eum
          voluptas reiciendis nisi, quam assumenda explicabo obcaecati
          laboriosam voluptates delectus dignissimos impedit sequi ullam
          quibusdam nihil, enim consequatur aliquid, ab tenetur excepturi
          sapiente. Veritatis, corporis? Veniam placeat odio in. Officiis
          aperiam velit, error temporibus quasi quibusdam repellendus ea
          voluptatum blanditiis, eum voluptates cumque amet nisi sit magni
          minima corporis maiores hic nam doloremque asperiores, molestiae
          pariatur. Deserunt quisquam voluptas quaerat ut architecto odio vitae
          animi.
        </p>
        <div>
          <form>
            <label htmlFor="">
              <input type="text" placeholder="Please input text hear." />
            </label>
          </form>
        </div>
      </Container>
    </div>
  )
}

export default App
