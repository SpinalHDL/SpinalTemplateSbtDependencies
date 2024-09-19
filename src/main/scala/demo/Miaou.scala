package demo

import spinal.core._
import vexiiriscv.soc.demo.{MicroSoc, MicroSocParam}
import vexiiriscv.{ParamSimple, VexiiRiscv}

object Miaou extends App{
  val p = new MicroSocParam()
  SpinalVerilog(new MicroSoc(p))
}
