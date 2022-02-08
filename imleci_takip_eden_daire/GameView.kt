package com.example.simplegame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class GameView(context : Context) : View(context) {
    val paint:Paint                                                                                       /*2 */
    var circleX : Float                                                                                        /*3 */
    var circleY : Float                                                                               /*3.1 */
    val paint2:Paint
    init {
        paint=Paint()
        paint.isFilterBitmap=true
        paint.isAntiAlias=true
        paint.color=Color.YELLOW
        circleX=100f  /*3.2 */
        circleY=100f  /*3.3 */
    }
    init {
        paint2=Paint()
        paint2.isFilterBitmap=true
        paint2.isAntiAlias=true
        paint2.color=Color.DKGRAY
    }
    override fun draw(canvas: Canvas?) {                                                                            /*1 */
        super.draw(canvas)
        canvas?.drawColor(Color.RED)                                                                     //arka plan eflatun olsun
        canvas?.drawCircle(circleX,circleY,50f,paint)                                                   /*2.1-4.1 */
        //canvas?.drawLine(0f,700f,500f,700f,paint2)
        //canvas?.drawRect(0f,200f,500f,600f,paint2)
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {                                                             /*4*/ //burada ontouchevent'i okuyoruz ve bu her çağrıldğında imleci dokunuşa dokunurken bu dairenin konumunu değiştirelim
        circleX=event!!.x
        circleY=event!!.y
        invalidate()                                                                                                  //görünümü yenilemek için(pozisyonu güncelliyoruz.geçersiz kılmamız gereken her görünüm için draw yöntemini çağırmak istersiniz.)
        return true
    }
}
