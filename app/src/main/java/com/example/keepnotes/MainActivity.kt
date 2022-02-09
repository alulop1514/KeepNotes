package com.example.keepnotes

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setImageResource(R.drawable.iconofab)
        fab.setOnClickListener {
            val rotar = getDrawable(R.drawable.ad_rotacion) as AnimatedVectorDrawable
            fab.setImageDrawable(rotar)
            rotar.start()
        }
        val notas = ArrayList<Nota>()

        notas.add(Nota(R.string.note1))
        notas.add(Nota(R.string.note2))
        notas.add(Nota(R.string.note3))
        notas.add(Nota(R.string.note4))
        notas.add(Nota(R.string.note5))
        notas.add(Nota(R.string.note6))
        notas.add(Nota(R.string.note1))
        notas.add(Nota(R.string.note2))
        notas.add(Nota(R.string.note3))


        val recView = findViewById<RecyclerView>(R.id.recyclerView)
        recView.setHasFixedSize(true)

        val adaptador = NotaAdapter(notas)
        recView.adapter = adaptador
        adaptador.onClick = {
            println("hola" +
                    "")
            val textView = it.findViewById<TextView>(R.id.txt1)
                val cx = textView.getWidth()
                val cy = textView.getHeight()

                // Calculamos el máximo radio posible
                val radius = calculateMaxRadius(textView)

                val anim = ViewAnimationUtils.createCircularReveal(textView, cx, cy, 0f, radius)


                // Cuando la animación ha finalizado la imagen permanecerá invisib

                // Comenzamos la animación circular reveal.
                anim.duration = 2000
                anim.start()
        }
        recView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
    fun calculateMaxRadius(view: View): Float {
        val widthSquared = view.getWidth() * view.getWidth()
        val heightSquared = view.getHeight() * view.getHeight()
        return Math.sqrt((widthSquared + heightSquared / 2).toDouble()).toFloat()
    }
}
