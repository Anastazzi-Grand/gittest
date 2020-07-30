package ru.itmo.hometask10forchapter7

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var etNumber: EditText
    var tv = intArrayOf(
        R.id.tv0,
        R.id.tv1,
        R.id.tv2,
        R.id.tv3,
        R.id.tv4,
        R.id.tv5,
        R.id.tv6,
        R.id.tv7,
        R.id.tv8
    )
    var tvs = arrayOfNulls<TextView>(9)
    var nums = IntArray(9)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumber = findViewById(R.id.etNumber)
        for (i in tv.indices) tvs[i] = findViewById(tv[i])
    }

    fun fillArray(view: View) {
        for (i in nums.indices) nums[i] = (10..99).random()
        for (i in nums.indices) tvs[i]!!.text = "${nums[i]}"
        for (i in nums.indices) {
            tvs[i]!!.setTextColor(Color.BLACK)
            tvs[i]!!.setBackgroundColor(Color.WHITE)
        }
    }

    fun changePlaceRight(view: View) {
        if (checkArray(nums)) {
            val stNumber: String = etNumber.text.toString()
            if (stNumber == "") {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                etNumber.setText("")
                return
            }

            val number = stNumber.toInt()
            if (number in 1..8) {
                var obj = nums[number - 1]
                nums[number - 1] = nums[number]
                nums[number] = obj

                nums.forEachIndexed { index, _ ->
                    tvs[index]!!.text = "${nums[index]}"
                    if (index == number - 1) {
                        tvs[index]!!.setTextColor(Color.BLACK)
                        tvs[index]!!.setBackgroundColor(Color.GREEN)
                    }
                    if (index == number) {
                        tvs[index]!!.setTextColor(Color.BLACK)
                        tvs[index]!!.setBackgroundColor(Color.GREEN)
                    }
                }

            } else Toast.makeText(this, "This is the boundary of the array", Toast.LENGTH_SHORT)
                .show()

        } else Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }

    fun changePlaceLeft(view: View) {
        if (checkArray(nums)) {
            val stNumber: String = etNumber.text.toString()
            if (stNumber == "") {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                etNumber.setText("")
                return
            }

            val number = stNumber.toInt()
            if (number in 2..9) {
                var obj = nums[number - 1]
                nums[number - 1] = nums[number - 2]
                nums[number - 2] = obj

                nums.forEachIndexed { index, _ ->
                    tvs[index]!!.text = "${nums[index]}"
                    if (index == number - 1) {
                        tvs[index]!!.setTextColor(Color.BLACK)
                        tvs[index]!!.setBackgroundColor(Color.RED)
                    }
                    if (index == number - 2) {
                        tvs[index]!!.setTextColor(Color.BLACK)
                        tvs[index]!!.setBackgroundColor(Color.RED)
                    }
                }
            } else Toast.makeText(this, "This is the boundary of the array", Toast.LENGTH_SHORT)
                .show()

        } else Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }
    fun reverseReplacement(view: View) {
        if (checkArray(nums)) {
            val stNumber: String = etNumber.text.toString()
            if (stNumber == "") {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                etNumber.setText("")
                return
            }

            val number = stNumber.toInt()
            if (number in 1..9) {
                nums[number - 1] = -nums[number - 1]

                nums.forEachIndexed { index, _ ->
                    tvs[index]!!.text = "${nums[index]}"
                    if (index == number - 1) {
                        tvs[index]!!.setTextColor(Color.BLACK)
                        tvs[index]!!.setBackgroundColor(Color.YELLOW)
                    }
                }
            } else Toast.makeText(this, "This is the boundary of the array", Toast.LENGTH_SHORT)
                .show()

        } else Toast.makeText(this, "Error", Toast.LENGTH_SHORT)
        .show()
    }

    fun swapFirstCell(view: View) {
        if (checkArray(nums)) {
            val stNumber: String = etNumber.text.toString()
            if (stNumber == "") {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                etNumber.setText("")
                return
            }

            val number = stNumber.toInt()
            if (number in 1..9) {
                var obj = nums[number - 1]
                nums[number - 1] = nums[0]
                nums[0] = obj

                nums.forEachIndexed { index, _ ->
                    tvs[index]!!.text = "${nums[index]}"
                    if (index == number - 1) {
                        tvs[index]!!.setTextColor(Color.BLACK)
                        tvs[index]!!.setBackgroundColor(Color.CYAN)
                    }
                    if (index == 0) {
                        tvs[index]!!.setTextColor(Color.BLACK)
                        tvs[index]!!.setBackgroundColor(Color.CYAN)
                    }
                }
            } else Toast.makeText(this, "This is the boundary of the array", Toast.LENGTH_SHORT)
                .show()

        } else Toast.makeText(this, "Error", Toast.LENGTH_SHORT)
            .show()
    }

    fun swapLastCell(view: View) {
        if (checkArray(nums)) {
            val stNumber: String = etNumber.text.toString()
            if (stNumber == "") {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                etNumber.setText("")
                return
            }

            val number = stNumber.toInt()
            if (number in 1..9) {
                var obj = nums[number - 1]
                nums[number - 1] = nums[8]
                nums[8] = obj

                nums.forEachIndexed { index, _ ->
                    tvs[index]!!.text = "${nums[index]}"
                    if (index == number - 1) {
                        tvs[index]!!.setTextColor(Color.BLACK)
                        tvs[index]!!.setBackgroundColor(Color.MAGENTA)
                    }
                    if (index == 8) {
                        tvs[index]!!.setTextColor(Color.BLACK)
                        tvs[index]!!.setBackgroundColor(Color.MAGENTA)
                    }
                }
            } else Toast.makeText(this, "This is the boundary of the array", Toast.LENGTH_SHORT)
                .show()

        } else Toast.makeText(this, "Error", Toast.LENGTH_SHORT)
            .show()
    }

    private fun checkArray(array: IntArray): Boolean {
        var check = true
        for (i in array.indices) if (array[i] == 0) check = false
        return check
    }
}