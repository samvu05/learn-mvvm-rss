package com.sam.learnmvvm

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sam.learnmvvm.databinding.ActivityMainBinding
import org.w3c.dom.Element
import java.net.URL
import javax.xml.parsers.DocumentBuilderFactory

class MainActivity : AppCompatActivity() {
    private var rssDatas = mutableListOf<RssData>()
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil
            .setContentView(this,R.layout.activity_main)
        createAsy()
        binding.rcDemo.layoutManager = LinearLayoutManager(this)
        binding.rcDemo.adapter = RssAdapter(rssDatas)
    }

    private fun createAsy() {
        val asy = object : AsyncTask<Void,Void,Void>() {
            override fun doInBackground(vararg p0: Void?): Void? {
                readData()
                return null
            }

            override fun onPostExecute(result: Void?) {
                binding.rcDemo.adapter?.notifyDataSetChanged()

            }

        }
        asy.execute()
    }
    private fun readData(){
        val link = "https://cdn.24h.com.vn/upload/rss/trangchu24h.rss"
        val inP = URL(link).openConnection().getInputStream()
        val builderFactory = DocumentBuilderFactory.newInstance()
        val docBuilder = builderFactory.newDocumentBuilder()
        val doc = docBuilder.parse(inP)
        val listNot = doc.getElementsByTagName("item")
        for (i in 0..listNot.length - 1) {
            val node = listNot.item(i) as Element
            val title = node.getElementsByTagName("title").item(0).textContent
            val pubDate = node.getElementsByTagName("pubDate").item(0).textContent
            val description = node.getElementsByTagName("description").item(0).textContent
            val img = ((node.getElementsByTagName("description").item(0) as Element).getElementsByTagName("img").item(0) as Element).getAttribute("src")
            rssDatas.add(
                RssData(title, description, img)
            )
        }

        Log.d("sdf", "sdf")

    }
}