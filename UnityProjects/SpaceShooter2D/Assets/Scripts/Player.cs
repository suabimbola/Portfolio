using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{
    [SerializeField]
    private GameObject _laser;
    [SerializeField]
    private int _lives = 3;

    private float _speed = 3.5f;
    private float _fireRate = 0.2f;
    private float _nextFire = 0.0f;
    private bool dead = false;

    void Start()
    {
        //start position
        transform.position = new Vector3(0, 0, 0);

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

        transform.Translate(moveDir * _speed * Time.deltaTime);

    //clamping player movement in the y plane between -3.9, 0
        transform.position = new Vector3(transform.position.x, Mathf.Clamp(transform.position.y, -3.9f, 0), 0);

        if (transform.position.x >= 9.5f)
        {
            transform.position = new Vector3(-9.5f, transform.position.y, 0);

        }
        else if (transform.position.x <= -9.5f)
        {
            transform.position = new Vector3(9.5f, transform.position.y, 0);

        }
    }

    void FireLaser()
    {
        _nextFire = Time.time + _fireRate;
        Instantiate(_laser, transform.position + new Vector3(0, 0.8f, 0), Quaternion.identity);

    }

    public void Damage()
    {
        _lives--;

        if (_lives < 1)
        {
            Destroy(this.gameObject);

        }
    }
}
