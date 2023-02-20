using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class UIManager : MonoBehaviour
{
    [SerializeField]
    private Text _scoreText;
    [SerializeField]
    private Sprite[] _lives;
    [SerializeField]
    private Image _livesImg;
    [SerializeField]
    private GameObject _gameOverText;
    [SerializeField]
    private GameObject _restartText;

    private GameManager _gameManager;

    void Start()
    {
        _gameManager = GameObject.Find("GameManager").GetComponent<GameManager>();

        if(_gameManager == null)
        {
            Debug.LogError("Game Manager not found.");

        }

        _scoreText.text = "Score: " + 0;
        
    }

    public void UpdateScore(int score)
    {
        _scoreText.text = "Score: " + score.ToString();

    }

    public void UpdateLives(int currentLives)
    {
        _livesImg.sprite = _lives[currentLives];

        if(currentLives == 0)
        {
            GameOver();

        }

    }

    public void GameOver()
    {
        _gameOverText.SetActive(true);
        _restartText.SetActive(true);
        _gameManager.GameOver();

    }

}
