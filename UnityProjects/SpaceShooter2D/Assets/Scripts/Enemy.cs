using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy : MonoBehaviour
{
    private float _speed = 4f;
    private Player _player;
    private Animator _enemyAnim;

    void Start()
    {
        _player = GameObject.Find("Player").GetComponent<Player>();

        if (_player == null)
        {
            Debug.LogError("Player not found.");

        }

        _enemyAnim = GetComponent<Animator>();

        if(_enemyAnim == null)
        {
            Debug.LogError("Enemy animator not found.");

        }

        transform.position = new Vector3(Random.Range(-8f, 8f), 7, 0);
        
    }

    void Update()
    {
        transform.Translate(Vector3.down * _speed * Time.deltaTime);

        if (transform.position.y < -5.4f)
        {
            float randX = Random.Range(-8f, 8f);
            transform.position = new Vector3(randX, 7, 0);

        }

        if (_player._isDead)
        {
            Destroy(this.gameObject, 3);

        }
    }

    void OnTriggerEnter2D(Collider2D other)
    {
        if (other.tag == "Player")
        {
            _player.Damage();
            _enemyAnim.SetTrigger("EnemyDeath");
            _speed = 0;
            Destroy(this.gameObject, 2.38f);

        }
        
        if (other.tag == "Laser")
        {
            Destroy(other.gameObject);
            _player.AddScore(10);
            _enemyAnim.SetTrigger("EnemyDeath");
            _speed = 0;
            Destroy(this.gameObject, 2.38f);
            
        }
    }
}
