import NavBar from "../components/NavBar";
import Footer from "../components/Footer";
import {CrediCardIcon} from '@'

export default function Contas() {
  return (
    <div>
      <NavBar />
      <main className="bg-slate-900 m-20 p-8">
        <h2 className="text-xl">Contas</h2>
        
        <div id="data">
          <div id="data-row" className=" flex justify-between hover:bg-slate-800 p-2 
          my-2 rounded cursor-pointer"> 
          <span> I</span>
          <span>Itaú </span>
          
        </div>
        <span> R$ 100.00</span>
        </div>
      </main>
      <Footer />
    </div>
  );
}