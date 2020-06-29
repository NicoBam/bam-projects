package fr.haan.bamprojects.ui

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.haan.bamprojects.data.model.State


var errorDisplayer : ErrorDisplayer? = null


/**
 * Very basic error handler allowing to report errors from class in any layer
 */
class ErrorDisplayer(val currentActivity: AppCompatActivity) {
    fun displayError(error: State.Error<*>) {
        currentActivity.runOnUiThread {
            Toast
                .makeText(currentActivity,error.error, Toast.LENGTH_LONG)
                .show()
        }

    }
}