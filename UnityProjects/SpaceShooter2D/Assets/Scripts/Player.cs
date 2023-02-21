using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{
    [SerializeField]
    private GameObject _laser;
    [SerializeField]
    private GameObject _tripleShotPrefab;
    [SerializeField]
    private GameObject _playerShield;
    [SerializeField]
    private GameObject _explosion;
    [SerializeField]
    private GameObject[] _engines;

    private UIManager _uiManager;
    private float _speed = 3.5f;
    private float _speedMultiplier = 2f;
    private float _fireRate = 0.2f;
    private float _nextFire = 0.0f;
    private bool _tripleShot = false;
    private bool _speedBoost = false;
    private bool _shield = false;
    private bool _damage = false;
    private int _lives = 3;
    private int _score;

    public bool _isDead = false;

    void Start()
    {
        transform.position = new Vector3(0, 0, 0);

        _uiManager = GameObject.Find("Canvas").GetComponent<UIManager>();

        if(_uiManager == null)
        {
            Debug.LogError("UI Manager not found.");

        }

    }

    void Update()
    {
        PlayerMovement();
        
        if (Input.GetKeyDown(KeyCode.Space) && Time.time > _nextFire)
        {
            FireLaser();

        }
    }

    void PlayerMovement()
    {
        float horizontalIn = Input.GetAxis("Horizontal");
        float verticalIn = Input.GetAxis("Vertical");
        Vector3 moveDir = new Vector3(horizontalIn, verticalIn, 0);

        if(_speedBoost == false)
        {
            transform.Translate(moveDir * _speed * Time.deltaTime);

        }else if(_speedBoost == true){
            transform.Translate(moveDir * _speed * _speedMultiplier * Time.deltaTime);
        }
        
    //clamping player movement in the y plane between -3.9, 0
        transform.position = new Vector3(transform.position.x, Mathf.Clamp(transform.position.y, -3.9f, 0), 0);

        if (transform.position.x >= 11f)
        {
            transform.position = new Vector3(-11f, transform.position.y, 0);

        }
        else if (transform.position.x <= -11f)
        {
            transform.position = new Vector3(11f, transform.position.y, 0);

        }
    }

    void FireLaser()
    {
        _nextFire = Time.time + _fireRate;

        if(_tripleShot == true)
        {
            Instantiate(_tripleShotPrefab, transform.position, Quaternion.identity);
        }else{
            Instantiate(_laser, transform.position + new Vector3(0, 1f, 0), Quaternion.identity);

        }
    }

    public void Damage()
    {
        if(_shield == true)
        {
            _shield = false;
            _playerShield.SetActive(false);
            return;

        }

        _damage = true;
        _lives--;
        _uiManager.UpdateLives(_lives);

        while(_damage == true)
        {
            for(int i = 0; i < 1; i++)
            {
                int randomEngine = Random.Range(0, 2);
                if(!_engines[randomEngine].activeSelf)
                {
                    _engines[randomEngine].SetActive(true);
                    _damage = false;

                }
                else if(_engines[0].activeSelf && _engines[1].activeSelf)
                {
                    _damage = false;
                }
                else i--;

            }
        }

        if (_lives < 1)
        {
            _isDead = true;
            Instantiate(_explosion, transform.position, Quaternion.identity);
            Destroy(this.gameObject, 0.25f);

        }
    }

    public void TripleShot()
    {
        _tripleShot = true;
        StopCoroutine("TripleShotActive");
        StartCoroutine("TripleShotActive");

    }


    IEnumerator TripleShotActive()
    {
        while( _tripleShot == true)
        {
            yield return new WaitForSeconds(5f);
            _tripleShot = false;

        }
    }

    public void SpeedBoost()
    {
        _speedBoost = true;
        StopCoroutine("SpeedBoostActive");
        StartCoroutine("SpeedBoostActive");

    }

    IEnumerator SpeedBoostActive()
    {
        yield return new WaitForSeconds(5f);
        _speedBoost = false;

    }

    public void Shield()
    {
        _shield = true;
        _playerShield.SetActive(true);
        StopCoroutine("ShieldActive");
        StartCoroutine("ShieldActive");

    }

    IEnumerator ShieldActive()
    {
        yield return new WaitForSeconds(10f);
        _playerShield.SetActive(false);
        _shield = false;

    }

    public void AddScore(int points)
    {
        _score += points;
        _uiManager.UpdateScore(_score);

    }

}
