import NavBar from "../components/NavBar"
import Footer from "../components/DropMenu"

export default function Despesas() {
  return (
    <>
      <NavBar active={"despesas"} />

      <main className="bg-slate-900 m-20 p-6">
        <h2>Despesas</h2>
      </main>

      

      <Footer active={"despesas"} />

      
     
    </>
  )
}
