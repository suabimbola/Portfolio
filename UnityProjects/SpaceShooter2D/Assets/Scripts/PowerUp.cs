using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PowerUp : MonoBehaviour
{
    [SerializeField] //0 = triple shot, 1 = speed boost, 2 = shield
    private int powerUpID;
    
    private Player _player;
    private float _speed = 3f;

    void Start()
    {
        _player = GameObject.Find("Player").GetComponent<Player>();

        if( _player == null)
        {
            Debug.LogError("Player not found.");

        }
    }

    void Update()
    {
        transform.Translate(Vector3.down * _speed * Time.deltaTime);

        if( transform.position.y < -5.4f)
        {
            Destroy(this.gameObject);

        }
    }

    private void OnTriggerEnter2D(Collider2D other)
    {
        if(other.tag == "Player")
        {
            switch(powerUpID)
            {
                case 0:
                    _player.TripleShot();
                    break;
                case 1:
                    _player.SpeedBoost();
                    break;
                case 2:
                _player.Shield();
                break;

            }
            Destroy(this.gameObject);

        }
    } 
}
