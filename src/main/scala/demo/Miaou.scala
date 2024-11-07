package demo

import spinal.core._
import vexiiriscv.soc.micro.{MicroSoc, MicroSocParam}
import vexiiriscv.{ParamSimple, VexiiRiscv}

object Miaou extends App{
  val p = new MicroSocParam()
  SpinalVerilog(new MicroSoc(p))
  println(libA.LibA.miaou)
}
