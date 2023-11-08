package com.dam23_24.dam2_composeejemplo1

import android.icu.text.DecimalFormat

@Suppress("SpellCheckingInspection")
class Calculo {

    private var num1: Float = 0f
    private var num2: Float = 0f
    private var op: Int = -1
    private var result: Float = 0f

    private var primerNum: Boolean = true // true -> Esperando num1 / false -> Esperando num2
    private var numTemp1: String = ""
    private var numTemp2: String = ""
    private var numCalculos: Int = 0
    var msjPpal: String = ""
    var msjDetalle: String = ""

    private val df = DecimalFormat("#.##")


    /**
     * Realiza la llamada al método adecuado para realizar el cálculo solicitado en la calculadora.
     */
    private fun calcular() {
        when (this.op) {
            0 -> this.suma()
            1 -> this.resta()
            2 -> this.multiplica()
            3 -> this.divide()
        }
        this.numCalculos += 1
    }


    /**
     * Realiza la suma de num1 y num2 y lo almacena en result.
     */
    private fun suma() {
        this.result = this.num1 + this.num2
    }


    /**
     * Realiza la resta de num1 y num2 y lo almacena en result
     */
    private fun resta() {
        this.result = this.num1 - this.num2
    }


    /**
     * Realiza la multiplicación de num1 y num2 y lo almacena en result
     */
    private fun multiplica() {
        this.result = this.num1 * this.num2
    }


    /**
     * Realiza la división de num1 y num2 y lo almacena en result
     */
    private fun divide() {
        this.result = this.num1 / this.num2
    }


    /**
     * Según el parámetro num, retornará el símbolo correspondiente a la operación
     *
     * @param num operación (0 -> + / 1 -> - / 2 -> * / 3 -> /
     * @return String con el símbolo de la operación
     */
    private fun operadorTxt(num: Int): String {
        return when (num) {
            0 -> "+"
            1 -> "-"
            2 -> "*"
            3 -> "/"
            else -> ""
        }
    }


    /**
     * Según this.op, retornará el símbolo correspondiente a la operación
     *
     * @return String con el símbolo de la operación
     */
    private fun operadorTxt(): String {
        return when (this.op) {
            0 -> "+"
            1 -> "-"
            2 -> "*"
            3 -> "/"
            else -> ""
        }
    }


    /**
     * Tratamiento de la operación cuando estamos introduciendo el primer número.
     */
    private fun actualizaOperadorPrimerNum(num: Int) {

        if (this.numCalculos > 0 && this.numTemp1 == "") {
            //Si hay un cálculo anterior y el num1 aún está vacío, el resultado anterior es el
            // num1 del siguiente cálculo.
            this.num1 = this.result
            this.numTemp1 = df.format(this.result).toString()
        } else {
            //Sino, asignamos num1 del objeto calc convirtiendo los dígitos introducidos a float.
            //Además, si existe algún problema o cuando si se pulsa un operador sin introducir
            // número antes, lo capturamos y usamos el valor 0.
            try {
                this.num1 = this.numTemp1.toFloat()
            } catch (e: NumberFormatException) {
                this.num1 = 0f
                this.numTemp1 = "0"
            }
        }

        //Asignamos el operador al objeto calc, mostramos info en pantalla y actualizamos las
        // características necesarias de calc para indicar que pasamos al estado de introducir
        // el segundo número.
        this.op = num
        actualizaInfoPantallas(this.operadorTxt(), this.numTemp1 + this.operadorTxt())
        this.numTemp2 = ""
        this.primerNum = false

    }


    /**
     * Tratamiento de la operación cuando estamos introduciendo el segundo número.
     */
    private fun actualizaOperadorSegundoNum(num: Int) {

        //Convertimos la cadena de dígitos en el número 2 y realizamos el cálculo.
        //Si existe algún problema en la conversión la controlamos asignando el valor 0.
        this.num2 = try {
            this.numTemp2.toFloat()
        } catch (e: NumberFormatException) {
            0f
        }
        calcular()

        //Mostramos en pantalla el resultado del cálculo como detalle y la operación en la
        // pantalla principal.
        actualizaInfoPantallas(
            this.operadorTxt(num),
            df.format(this.result).toString() + this.operadorTxt(num)
        )

        //Actualizamos las características necesarias del objeto calc, ya que vamos a seguir en
        // el estado de introducir solo un segundo número, ya que el primer número y la operación
        // es asignado como el resultado del cálculo realizado y la nueva operación introducida.
        this.num1 = this.result
        this.op = num
        this.num2 = 0f
        this.numTemp1 = df.format(this.num1).toString()
        this.numTemp2 = ""

    }


    /**
     * Actualiza y almacena la información en cadenas de caracteres (this.numTemp1 y this.numTemp2)
     * de cada pulsación de los dígitos de los números que se usarán posteriormente en el cálculo y
     * acabarán siendo almacenados como this.num1 y this.num2.
     *
     * @param num que corresponde al dígito del 0 al 9 pulsado o al punto decimal (10)
     */
    fun tecleaDigito(num: Int) {

        //Si es menor que 10, se trata de un dígito del 0 al 9.
        //Sino, es el punto decimal.
        if (num < 10) {
            if (this.primerNum) this.numTemp1 += num.toString()
            else this.numTemp2 += num.toString()
        } else {
            if (this.primerNum) {
                //Si no se tecleo ningún dígito antes del punto decimal, establecemos el valor 0.
                //Sino, lo agregamos a la cadena siempre que no exista ya con anterioridad
                if (this.numTemp1 == "") this.numTemp1 = "0."
                else this.numTemp1 += if (this.numTemp1.contains('.')) "" else "."
                actualizaInfoPantallas(this.numTemp1, this.numTemp1)
            } else {
                //Mismas acciones, pero con la cadena que va recogiendo el número 2
                if (this.numTemp2 == "") this.numTemp2 = "0."
                else this.numTemp2 += if (this.numTemp2.contains('.')) "" else "."
            }
        }

        //Actualizamos la información de los mensajes que se mostrarán en la pantalla de la calculadora
        actualizaInfoPantallas()
    }


    /**
     * Actualiza y almacena la información del operador seleccionado para el cálculo.
     *
     * @param num que corresponde a cada operación (0 = Sumar / 1 = Restar / 2 = Multiplicar /
     * 3 = Dividir).
     */
    fun tecleaOperador(num: Int) {

        if (this.primerNum) {
            //Si estamos introduciendo el primer número, actualizamos la info necesaria.
            actualizaOperadorPrimerNum(num)
        } else if (this.numTemp2 == "") {
            //Si se introduce una operación y aún no existe el segundo número la nueva operación
            // debe reemplazar la operación anterior.
            this.op = num
            //Mostramos en pantalla la actualización del operador.
            actualizaInfoPantallas(this.operadorTxt(), this.numTemp1 + this.operadorTxt())
        } else {
            //Si estamos introduciendo el segundo número, actualizamos la info necesaria.
            actualizaOperadorSegundoNum(num)
        }

    }


    /**
     * Elimina un dígito en las cadenas de caracteres (this.numTemp1 y this.numTemp2) según el
     * número que esté introduciendo el usuario o la operación.
     *
     * @return Boolean indicando si se pudo borrar el dígito o no fue posible.
     */
    fun borraDigito(): Boolean {

        var ret = false

        //Comprobamos si está introduciendo el primer o segundo número y si no están vacíos
        if (this.primerNum) {
            if (this.numTemp1.isNotEmpty()) {
                this.numTemp1 = this.numTemp1.substring(0, this.numTemp1.length - 1)
                ret = true
            }
        } else {
            ret = if (this.numTemp2.isNotEmpty()) {
                this.numTemp2 = this.numTemp2.substring(0, this.numTemp2.length - 1)
                true
            } else {
                //Eliminar la operación
                this.op = -1
                this.primerNum = true
                true
            }
        }

        //Actualizamos la información de los mensajes que se mostrarán en la pantalla de la calculadora
        actualizaInfoPantallas()

        return ret
    }


    /**
     * Realiza el cálculo solicitado por el usuario y lo almacena en la propiedad this.result.
     *
     * @return Boolean indicando si se pudo realizar el cálculo o no era posible.
     */
    fun pulsaResult(): Boolean {
        if (!this.primerNum && this.numTemp2 != "") {
            //Si estamos introduciendo el segundo número, lo actualizamos convirtiendo la cadena de
            // dígitos y calculamos la operación.
            this.num2 = try {
                this.numTemp2.toFloat()
            } catch (e: NumberFormatException) {
                0f
            }
            calcular()

            //Actualizamos en el mensaje ppal el resultado y en el mensaje detalle toda la operación
            // (num1 + num2 = result) formateando a 2 posiciones decimales.
            actualizaInfoPantallas(
                pantalla = df.format(this.result).toString(),
                detalle = df.format(this.num1).toString() +
                        this.operadorTxt() +
                        df.format(this.num2).toString() +
                        "=" +
                        df.format(this.result).toString()
            )

            //Inicializamos las características del objeto calc, excepto el número de cálculos.
            iniValores(resetNumCalculos = false, resetResult = false)
            return true
        } else {
            return false
        }
    }


    /**
     * Actualiza la información que se muestra en pantalla (ppal y detalle).
     */
    private fun actualizaInfoPantallas() {
        //Actualizamos la información de los mensajes que se mostrarán en la pantalla de la calculadora
        if (this.primerNum) {
            actualizaInfoPantallas(pantalla = this.numTemp1, detalle = this.numTemp1)
        } else {
            actualizaInfoPantallas(
                pantalla = this.numTemp2.ifEmpty { this.operadorTxt() },
                detalle = this.numTemp1 + this.operadorTxt() + this.numTemp2
            )
        }
    }


    /**
     * Actualiza la información que se muestra en pantalla (ppal y detalle).
     *
     * @param pantalla info a mostrar en el Text ppal.
     * @param detalle info a mostrar en el Text detalle.
     */
    private fun actualizaInfoPantallas(pantalla: String, detalle: String) {
        this.msjPpal = pantalla
        this.msjDetalle = detalle
    }


    /**
     * Inicializa las características del objeto calc.
     *
     * @param resetNumCalculos indica si ponemos a 0 o no el valor de numCalculos.
     *        (por defecto es true)
     * @param resetResult indica si ponemos a 0 o no el valor de result.
     *        (por defecto es true)
     */
    fun iniValores(resetNumCalculos: Boolean = true, resetResult: Boolean = true) {
        this.num1 = 0f
        this.num2 = 0f
        this.op = -1

        if (resetResult) this.result = 0f

        this.primerNum = true
        this.numTemp1 = ""
        this.numTemp2 = ""

        if (resetNumCalculos) this.numCalculos = 0

        if (resetResult) actualizaInfoPantallas("", "")
    }

}