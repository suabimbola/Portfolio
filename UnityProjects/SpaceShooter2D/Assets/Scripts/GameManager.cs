﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class GameManager : MonoBehaviour
{
    private bool _gameOver = false;

    void Update()
    {
        if(Input.GetKeyDown(KeyCode.R) && _gameOver == true)
        {
            SceneManager.LoadScene(0); //current scene
        }

    }

    public void GameOver()
    {
        _gameOver = true;

    }
    
}
