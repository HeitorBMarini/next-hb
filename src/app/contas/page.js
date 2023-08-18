import NavBar from "../components/NavBar";
import Footer from "../components/Footer";

export default function Contas() {
  return (
    <>
      <NavBar active={"contas"} />

      <main className="bg-slate-900 m-20 p-8">
        <h2>Contas</h2>
      </main>



      <Footer active={"contas"} />
      
    </>
  )
}
